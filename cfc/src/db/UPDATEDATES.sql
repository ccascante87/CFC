create or replace function UPDATE_DATES return number as my_result NUMBER;
 hoy Number := 0;
 dias number :=0;
begin
  hoy:=  EXTRACT(DAY FROM  sysdate);
  for fila in (select id, fecha from cfcuser.pivot)loop
    dias := hoy - EXTRACT(DAY FROM fila.fecha);
    update pivot 
      set fecha = fila.fecha + dias
      where fila.id = id;
  end loop;
  return 1;
end;