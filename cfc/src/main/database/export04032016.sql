--------------------------------------------------------
--  File created - Wednesday-April-06-2016   
--------------------------------------------------------
DROP TABLE "CFCUSER"."SUCURSALES" cascade constraints;
DROP TABLE "CFCUSER"."HISTORICOS" cascade constraints;
DROP TABLE "CFCUSER"."MOVIMIENTOS" cascade constraints;
DROP TABLE "CFCUSER"."SALDOS" cascade constraints;
--------------------------------------------------------
--  DDL for Table SUCURSALES
--------------------------------------------------------

  CREATE TABLE "CFCUSER"."SUCURSALES" 
   (	"CODIGO_AGENCIA" NUMBER, 
	"NOM_AGENCIA" VARCHAR2(50 BYTE), 
	"MONTO_ASEGURADO" NUMBER, 
	"MONTO_AUTORIZADO" NUMBER, 
	"HORA_APERTURA" TIMESTAMP (6), 
	"HORA_CIERRE" TIMESTAMP (6), 
	"ID_SUCURSAL" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table HISTORICOS
--------------------------------------------------------

  CREATE TABLE "CFCUSER"."HISTORICOS" 
   (	"CODIGO_EMPRESA" NUMBER, 
	"FECHA_VALIDA" TIMESTAMP (6), 
	"CODIGO_REGION" VARCHAR2(20 BYTE), 
	"NOM_REGION" VARCHAR2(50 BYTE), 
	"CODIGO_AGENCIA" NUMBER, 
	"NOM_AGENCIA" VARCHAR2(50 BYTE), 
	"CODIGO_USUARIO" NUMBER, 
	"NOM_USUARIO" VARCHAR2(50 BYTE), 
	"HORA_MOVIMIENTO" TIMESTAMP (6), 
	"CODIGO_TIPO_TRANSACCION" NUMBER, 
	"CODIGO_MONEDA" VARCHAR2(20 BYTE), 
	"ENTRADA_SALIDA" VARCHAR2(20 BYTE), 
	"CLIENTE_EMPRESA" VARCHAR2(20 BYTE), 
	"DESC_TRANSACCION" VARCHAR2(50 BYTE), 
	"MONTO_VALOR" NUMBER, 
	"ID_HISTORICO" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table MOVIMIENTOS
--------------------------------------------------------

  CREATE TABLE "CFCUSER"."MOVIMIENTOS" 
   (	"CODIGO_EMPRESA" NUMBER, 
	"FECHA_VALIDA" TIMESTAMP (6), 
	"CODIGO_REGION" VARCHAR2(20 BYTE), 
	"NOM_REGION" VARCHAR2(50 BYTE), 
	"CODIGO_AGENCIA" NUMBER, 
	"NOM_AGENCIA" VARCHAR2(50 BYTE), 
	"CODIGO_USUARIO" NUMBER, 
	"NOM_USUARIO" VARCHAR2(50 BYTE), 
	"HORA_MOVIMIENTO" TIMESTAMP (6), 
	"CODIGO_TIPO_TRANSACCION" NUMBER, 
	"CODIGO_MONEDA" VARCHAR2(20 BYTE), 
	"ENTRADA_SALIDA" VARCHAR2(20 BYTE), 
	"CLIENTE_EMPRESA" VARCHAR2(20 BYTE), 
	"DESC_TRANSACCION" VARCHAR2(50 BYTE), 
	"MONTO_VALOR" NUMBER, 
	"ID_MOVIMIENTO" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table SALDOS
--------------------------------------------------------

  CREATE TABLE "CFCUSER"."SALDOS" 
   (	"CODIGO_USUARIO" VARCHAR2(20 BYTE), 
	"NOM_USUARIO" VARCHAR2(50 BYTE), 
	"CODIGO_AGENCIA" NUMBER, 
	"NOM_AGENCIA" VARCHAR2(20 BYTE), 
	"CODIGO_MONEDA" VARCHAR2(20 BYTE), 
	"FECHA" TIMESTAMP (6), 
	"ID_SALDO" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into CFCUSER.SUCURSALES
SET DEFINE OFF;
Insert into CFCUSER.SUCURSALES (CODIGO_AGENCIA,NOM_AGENCIA,MONTO_ASEGURADO,MONTO_AUTORIZADO,HORA_APERTURA,HORA_CIERRE,ID_SUCURSAL) values (1,'GUAPILES',null,null,null,null,12);
Insert into CFCUSER.SUCURSALES (CODIGO_AGENCIA,NOM_AGENCIA,MONTO_ASEGURADO,MONTO_AUTORIZADO,HORA_APERTURA,HORA_CIERRE,ID_SUCURSAL) values (2,'LIMON',null,null,null,null,11);
Insert into CFCUSER.SUCURSALES (CODIGO_AGENCIA,NOM_AGENCIA,MONTO_ASEGURADO,MONTO_AUTORIZADO,HORA_APERTURA,HORA_CIERRE,ID_SUCURSAL) values (3,'CENTRAL',null,null,null,null,101);
Insert into CFCUSER.SUCURSALES (CODIGO_AGENCIA,NOM_AGENCIA,MONTO_ASEGURADO,MONTO_AUTORIZADO,HORA_APERTURA,HORA_CIERRE,ID_SUCURSAL) values (4,'PUNTARENAS',null,null,null,null,102);
Insert into CFCUSER.SUCURSALES (CODIGO_AGENCIA,NOM_AGENCIA,MONTO_ASEGURADO,MONTO_AUTORIZADO,HORA_APERTURA,HORA_CIERRE,ID_SUCURSAL) values (5,'LIBERIA',null,null,null,null,103);
REM INSERTING into CFCUSER.HISTORICOS
SET DEFINE OFF;
Insert into CFCUSER.HISTORICOS (CODIGO_EMPRESA,FECHA_VALIDA,CODIGO_REGION,NOM_REGION,CODIGO_AGENCIA,NOM_AGENCIA,CODIGO_USUARIO,NOM_USUARIO,HORA_MOVIMIENTO,CODIGO_TIPO_TRANSACCION,CODIGO_MONEDA,ENTRADA_SALIDA,CLIENTE_EMPRESA,DESC_TRANSACCION,MONTO_VALOR,ID_HISTORICO) values (1,to_timestamp('16-MAR-16 02.28.29.501000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'01','SAN JOSE',3,'CENTRAL',2,'MARIA',to_timestamp('15-MAR-16 02.29.13.643000000 AM','DD-MON-RR HH.MI.SSXFF AM'),null,'DOLARES','E','C','EFECTIVO SALIDA
',545322.2,2);
Insert into CFCUSER.HISTORICOS (CODIGO_EMPRESA,FECHA_VALIDA,CODIGO_REGION,NOM_REGION,CODIGO_AGENCIA,NOM_AGENCIA,CODIGO_USUARIO,NOM_USUARIO,HORA_MOVIMIENTO,CODIGO_TIPO_TRANSACCION,CODIGO_MONEDA,ENTRADA_SALIDA,CLIENTE_EMPRESA,DESC_TRANSACCION,MONTO_VALOR,ID_HISTORICO) values (1,to_timestamp('16-MAR-16 02.20.21.515000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'06','PUNTARENAS',4,'PUNTARENAS',1,'MARIA',to_timestamp('16-MAR-16 02.20.28.970000000 AM','DD-MON-RR HH.MI.SSXFF AM'),1,'COLONES','E','C','DEPOSITO EN EFECTIVO',20000,1);
REM INSERTING into CFCUSER.MOVIMIENTOS
SET DEFINE OFF;
Insert into CFCUSER.MOVIMIENTOS (CODIGO_EMPRESA,FECHA_VALIDA,CODIGO_REGION,NOM_REGION,CODIGO_AGENCIA,NOM_AGENCIA,CODIGO_USUARIO,NOM_USUARIO,HORA_MOVIMIENTO,CODIGO_TIPO_TRANSACCION,CODIGO_MONEDA,ENTRADA_SALIDA,CLIENTE_EMPRESA,DESC_TRANSACCION,MONTO_VALOR,ID_MOVIMIENTO) values (1,null,'01','SAN JOSE',3,'CENTRAL',1,'JUAN',null,null,'COLONES','E',null,null,null,22);
Insert into CFCUSER.MOVIMIENTOS (CODIGO_EMPRESA,FECHA_VALIDA,CODIGO_REGION,NOM_REGION,CODIGO_AGENCIA,NOM_AGENCIA,CODIGO_USUARIO,NOM_USUARIO,HORA_MOVIMIENTO,CODIGO_TIPO_TRANSACCION,CODIGO_MONEDA,ENTRADA_SALIDA,CLIENTE_EMPRESA,DESC_TRANSACCION,MONTO_VALOR,ID_MOVIMIENTO) values (2,null,'06','PUNTARENAS',4,'PUNTARENAS',2,'MARIA',null,null,'DOLARES','E',null,null,null,33);
Insert into CFCUSER.MOVIMIENTOS (CODIGO_EMPRESA,FECHA_VALIDA,CODIGO_REGION,NOM_REGION,CODIGO_AGENCIA,NOM_AGENCIA,CODIGO_USUARIO,NOM_USUARIO,HORA_MOVIMIENTO,CODIGO_TIPO_TRANSACCION,CODIGO_MONEDA,ENTRADA_SALIDA,CLIENTE_EMPRESA,DESC_TRANSACCION,MONTO_VALOR,ID_MOVIMIENTO) values (3,null,'05','GUANACASTE',5,'LIBERIA',1,'JUAN',null,null,'COLONES','S',null,null,null,44);
REM INSERTING into CFCUSER.SALDOS
SET DEFINE OFF;
Insert into CFCUSER.SALDOS (CODIGO_USUARIO,NOM_USUARIO,CODIGO_AGENCIA,NOM_AGENCIA,CODIGO_MONEDA,FECHA,ID_SALDO) values ('1','JUAN',4,'PUNTARENAS','COLONES',to_timestamp('07-APR-16 04.10.22.209000000 AM','DD-MON-RR HH.MI.SSXFF AM'),200);
Insert into CFCUSER.SALDOS (CODIGO_USUARIO,NOM_USUARIO,CODIGO_AGENCIA,NOM_AGENCIA,CODIGO_MONEDA,FECHA,ID_SALDO) values ('2','MARIA',3,'CENTRAL','DOLARES',to_timestamp('07-APR-16 04.10.18.575000000 AM','DD-MON-RR HH.MI.SSXFF AM'),3300);
Insert into CFCUSER.SALDOS (CODIGO_USUARIO,NOM_USUARIO,CODIGO_AGENCIA,NOM_AGENCIA,CODIGO_MONEDA,FECHA,ID_SALDO) values ('3','CARLOS',5,'LIBERIA','COLONES',to_timestamp('07-APR-16 04.09.21.378000000 AM','DD-MON-RR HH.MI.SSXFF AM'),5850);
Insert into CFCUSER.SALDOS (CODIGO_USUARIO,NOM_USUARIO,CODIGO_AGENCIA,NOM_AGENCIA,CODIGO_MONEDA,FECHA,ID_SALDO) values ('4','JORGE',1,'GUAPILES','COLONES',to_timestamp('07-APR-16 04.09.51.101000000 AM','DD-MON-RR HH.MI.SSXFF AM'),6500);
--------------------------------------------------------
--  DDL for Index SUCURSALES_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "CFCUSER"."SUCURSALES_PK" ON "CFCUSER"."SUCURSALES" ("ID_SUCURSAL") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index HISTORICOS_INDEX1
--------------------------------------------------------

  CREATE UNIQUE INDEX "CFCUSER"."HISTORICOS_INDEX1" ON "CFCUSER"."HISTORICOS" ("ID_HISTORICO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index MOVIMIENTOS_INDEX1
--------------------------------------------------------

  CREATE UNIQUE INDEX "CFCUSER"."MOVIMIENTOS_INDEX1" ON "CFCUSER"."MOVIMIENTOS" ("ID_MOVIMIENTO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SALDOS_INDEX1
--------------------------------------------------------

  CREATE UNIQUE INDEX "CFCUSER"."SALDOS_INDEX1" ON "CFCUSER"."SALDOS" ("ID_SALDO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table SUCURSALES
--------------------------------------------------------

  ALTER TABLE "CFCUSER"."SUCURSALES" MODIFY ("ID_SUCURSAL" NOT NULL ENABLE);
  ALTER TABLE "CFCUSER"."SUCURSALES" ADD CONSTRAINT "SUCURSALES_PK" PRIMARY KEY ("ID_SUCURSAL")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table HISTORICOS
--------------------------------------------------------

  ALTER TABLE "CFCUSER"."HISTORICOS" MODIFY ("ID_HISTORICO" NOT NULL ENABLE);
  ALTER TABLE "CFCUSER"."HISTORICOS" ADD CONSTRAINT "HISTORICOS_PK" PRIMARY KEY ("ID_HISTORICO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table MOVIMIENTOS
--------------------------------------------------------

  ALTER TABLE "CFCUSER"."MOVIMIENTOS" MODIFY ("ID_MOVIMIENTO" NOT NULL ENABLE);
  ALTER TABLE "CFCUSER"."MOVIMIENTOS" ADD CONSTRAINT "MOVIMIENTOS_PK" PRIMARY KEY ("ID_MOVIMIENTO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table SALDOS
--------------------------------------------------------

  ALTER TABLE "CFCUSER"."SALDOS" MODIFY ("ID_SALDO" NOT NULL ENABLE);
  ALTER TABLE "CFCUSER"."SALDOS" ADD CONSTRAINT "SALDOS_PK" PRIMARY KEY ("ID_SALDO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
