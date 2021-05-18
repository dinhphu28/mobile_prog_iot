USE master
GO

CREATE DATABASE smarthome
GO

USE smarthome
GO

-- USE master
-- GO
-- ALTER DATABASE smarthome SET SINGLE_USER WITH ROLLBACK IMMEDIATE
-- GO
-- DROP DATABASE smarthome
-- GO

-- Auth
CREATE TABLE accounts (
    uname VARCHAR(20),
    passwd NVARCHAR(50) NOT NULL,
	accounttype BIT NOT NULL,	-- 0: device | 1: admin

    PRIMARY KEY(uname)
)
GO

CREATE TABLE retokens (
	uname VARCHAR(20) REFERENCES dbo.accounts(uname),
	rtoken VARCHAR(300) NULL,

	PRIMARY KEY(uname)
)
GO

-- Devices state
CREATE TABLE devices (
	cid INT IDENTITY(1,1),
	devicename NVARCHAR(50) NOT NULL,
	devicedescription NVARCHAR(250) NULL,
	devicetype BIT NOT NULL,	-- 0: input | 1: output
	datatype BIT NOT NULL,	-- 0: bit | 1: decimal
	bitvalue BIT NOT NULL DEFAULT 0,
	decimalvalue FLOAT NOT NULL DEFAULT 0,

	PRIMARY KEY(cid)
)
GO

-- Logs
CREATE TABLE devicelogs (
	cid INT IDENTITY(1,1),
	deviceid INT REFERENCES dbo.devices(cid) NOT NULL,
	bitvalue BIT NOT NULL DEFAULT 0,
	decimalvalue FLOAT NOT NULL DEFAULT 0,
	daterecord DATE NOT NULL DEFAULT GETDATE(),
	timerecord TIME NOT NULL DEFAULT GETDATE(),

	PRIMARY KEY(cid)
)
GO
