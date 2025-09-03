-- Remover a coluna pessoa_id caso exista e seja do tipo BIGINT
ALTER TABLE presente DROP COLUMN IF EXISTS pessoa_id;

-- Adicionar a coluna pessoa_id do tipo TEXT
ALTER TABLE presente ADD COLUMN pessoa_id TEXT;