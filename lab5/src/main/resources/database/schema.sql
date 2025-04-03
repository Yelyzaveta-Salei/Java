-- Alter the system settings to allow connections
ALTER SYSTEM SET listen_addresses = '*';

-- Grant all privileges on the 'students' database to a user
GRANT ALL PRIVILEGES ON DATABASE students TO "user";

-- Create the table
CREATE TABLE IF NOT EXISTS students (
    id SERIAL PRIMARY KEY,
    last_name VARCHAR(50) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    middle_name VARCHAR(50),
    birth_date DATE NOT NULL,
    record_book_number VARCHAR(20) UNIQUE NOT NULL
);

-- Insert multiple student records into the 'students' table
INSERT INTO students (last_name, first_name, middle_name, birth_date, record_book_number)
VALUES
    ('Müller', 'Hans', 'Friedrich', '2001-02-15', '784512'),
    ('Schmidt', 'Klaus', 'Werner', '2000-03-20', '692347'),
    ('Schneider', 'Sabine', 'Christina', '2002-04-10', '573892'),
    ('Fischer', 'Anna', 'Elisabeth', '2001-05-25', '462901'),
    ('Weber', 'Peter', 'Johann', '2002-05-16', '583290'),
    ('Meyer', 'Lukas', 'Thomas', '2003-07-30', '749128'),
    ('Wagner', 'Max', 'Franz', '2000-01-12', '812345'),
    ('Becker', 'Maria', 'Katarina', '2001-03-18', '892376'),
    ('Hoffmann', 'Johannes', 'Karl', '2002-04-22', '956789'),
    ('Schäfer', 'Julia', 'Laura', '2000-05-14', '732109'),
    ('Koch', 'Daniel', 'Christian', '2001-07-03', '418765'),
    ('Bauer', 'Stefan', 'Heinz', '2002-08-19', '690987'),
    ('Richter', 'Eva', 'Monika', '2000-09-25', '935432'),
    ('Klein', 'Michael', 'Rudolf', '2001-10-11', '859345'),
    ('Wolf', 'Lisa', 'Annalise', '2002-11-30', '634678'),
    ('Schröder', 'Niklas', 'Anton', '2000-12-05', '471567'),
    ('Neumann', 'Ingrid', 'Helga', '2001-01-17', '519012'),
    ('Zimmermann', 'David', 'Markus', '2002-02-28', '732345'),
    ('Braun', 'Frank', 'Jürgen', '2000-03-15', '978890'),
    ('Krüger', 'Karin', 'Renate', '2001-04-20', '510123'),
    ('Hofmann', 'Philipp', 'Andreas', '2002-05-07', '635678'),
    ('Hartmann', 'Theresa', 'Birgit', '2000-07-22', '591901'),
    ('Lange', 'Felix', 'Wolfgang', '2001-08-14', '848234'),
    ('Schmitt', 'Sven', 'Bernd', '2002-09-09', '732567'),
    ('Maier', 'Claudia', 'Gisela', '2000-10-18', '599890'),
    ('Krause', 'Erik', 'Matthias', '2001-11-21', '653123'),
    ('Lehmann', 'Hannah', 'Ursula', '2002-12-03', '670456'),
    ('Fuchs', 'Tobias', 'Gerhard', '2000-01-29', '986789'),
    ('Pfeiffer', 'Leon', 'Horst', '2001-02-14', '742012'),
    ('Franke', 'Anja', 'Barbara', '2002-03-27', '839345');
ON CONFLICT (record_book_number) DO NOTHING;

-- Grant usage and select privileges on the 'students_id_seq' sequence to a specific user
GRANT USAGE, SELECT ON SEQUENCE students_id_seq TO "user";