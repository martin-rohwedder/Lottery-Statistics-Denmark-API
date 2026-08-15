CREATE TABLE draws (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    draw_date DATE NOT NULL,
    year INT NOT NULL,
    week_number INT NOT NULL,
    CONSTRAINT uq_year_week UNIQUE (year, week_number)
);

CREATE TABLE draw_numbers (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    draw_id BIGINT NOT NULL,
    number INT NOT NULL CHECK (number >= 1 AND number <= 36),
    is_bonus BOOLEAN NOT NULL DEFAULT FALSE,

    FOREIGN KEY (draw_id) REFERENCES draws(id) ON DELETE CASCADE,
    CONSTRAINT uq_draw_numbers UNIQUE (draw_id, number, is_bonus)
);

CREATE INDEX idx_draw_numbers_number ON draw_numbers(number);