CREATE TABLE pessoa (
                        id BIGSERIAL PRIMARY KEY,
                        nome VARCHAR(100) NOT NULL,
                        telefone VARCHAR(20),
                        presente TEXT
);

CREATE TABLE presente (
                          id BIGSERIAL PRIMARY KEY,
                          nome text NOT NULL
);
