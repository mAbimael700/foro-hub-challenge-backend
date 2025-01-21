-- Paso 1: Añadir la columna 'activo' de tipo 'tinyint'
ALTER TABLE topicos ADD COLUMN activo TINYINT;

-- Paso 2: Establecer el valor de 'activo' a 1 (que es equivalente a true)
UPDATE topicos SET activo = 1;

-- Paso 3: Modificar la columna 'activo' para que no permita valores nulos
ALTER TABLE topicos MODIFY COLUMN activo TINYINT NOT NULL;
