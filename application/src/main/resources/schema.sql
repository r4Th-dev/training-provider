CREATE TABLE person
(
    id          uuid PRIMARY KEY NOT NULL,
    name        text             NOT NULL,
    description text
);

CREATE TABLE training
(
    id          uuid PRIMARY KEY NOT NULL,
    name        text             NOT NULL,
    description text,
    price       long             NOT NULL,
    currency    text             NOT NULL
);

CREATE TABLE appointment
(
    id          uuid PRIMARY KEY NOT NULL,
    date        timestamp        NOT NULL,
    trainer_id  uuid             NOT NULL,
    training_id uuid             NOT NULL,
    CONSTRAINT fk_appointment_trainer_id FOREIGN KEY (trainer_id) REFERENCES person (id),
    CONSTRAINT fk_appointment_training_id FOREIGN KEY (training_id) REFERENCES training (id)
);

CREATE TABLE appointment_registrations
(
    registrations_id uuid NOT NULL,
    appointment_id   uuid NOT NULL
)
