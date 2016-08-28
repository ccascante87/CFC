alter table parameters add  short_desc varchar2(150) not null

INTO PARAMETERS
  (
    ID,
    PARAM_KEY,
    PARAM_VALUE,
    SHORT_DESC
  )
  VALUES
  (
    1,
    'graphUpdateInterval',
    '5',
    'Intervalo de tiempo (minutos) para actualizar el grafico'
  );