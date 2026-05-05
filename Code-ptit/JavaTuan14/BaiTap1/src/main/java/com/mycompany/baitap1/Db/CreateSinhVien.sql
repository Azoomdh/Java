
USE [BaiTapJava1]
GO

/****** Object:  Table [dbo].[SinhVien]    Script Date: 11-Nov-25 1:54:41 PM ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[SinhVien]') AND type in (N'U'))
DROP TABLE [dbo].[SinhVien]
GO

/****** Object:  Table [dbo].[SinhVien]    Script Date: 11-Nov-25 1:54:41 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[SinhVien](
	[masv] [nvarchar](50) NULL,
	[hoten] [nvarchar](50) NULL,
	[tenlop] [nvarchar](50) NULL,
	[gpa] [real] NULL
) ON [PRIMARY]
GO

