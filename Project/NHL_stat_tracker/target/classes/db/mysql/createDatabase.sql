# For hccis.ca version of the database
# DROP DATABASE IF EXISTS cis2232_nhl_tracker;
# CREATE DATABASE cis2232_nhl_tracker;
# use cis2232_nhl_tracker;

#For localhost
DROP DATABASE IF EXISTS cis2232_nhl_tracker;
CREATE DATABASE cis2232_nhl_tracker;
use cis2232_nhl_tracker;

-- ------------------------------------------------------------------------------
-- Note the table below to hold data associated with your project.  Expect one
-- table with 7-9 fields.
-- ------------------------------------------------------------------------------

CREATE TABLE PlayerTrackerData
(
    id                int(5),
    playerFirstName   varchar(50) NOT NULL COMMENT 'Athletes first name',
    playerLastName    varchar(50) NOT NULL COMMENT 'Athletes last name',
    playerPosition    varchar(50) NOT NULL COMMENT 'Player position',
    playerGoals       int(5) COMMENT 'Number of goals scored this season',
    playerAssists     int(5) COMMENT 'Number of assists this season',
    playerPenaltyMin  float(5) COMMENT 'Penalty mins round to nearest tenth of a second',
    playerMatches     int(5) COMMENT 'Number of matches played in the current season',
    playerWins        int(5) COMMENT 'Number of wins player has in the current season',
    playerLosses      int(5) COMMENT 'Number of losses player has in the current season',
    playerShots       int(5) COMMENT 'Number of shots on the net player has',
    playerSaves       int(5) COMMENT 'Number of saves if they are a goalie',
    playerPoints      int(5) COMMENT 'Number of points earned by player',
    playerPointsPerGame        int(5) COMMENT 'Score calculated at submission',
    playerScoringPercentage    int(5) COMMENT 'Score calculated at submission'
) COMMENT 'This table holds assessment details';

ALTER TABLE PlayerTrackerData
    ADD PRIMARY KEY (id);
ALTER TABLE PlayerTrackerData
    MODIFY id int(4) NOT NULL AUTO_INCREMENT COMMENT 'This is the primary key',
    AUTO_INCREMENT = 1;

-- test data goes here

--

CREATE TABLE CodeType (codeTypeId int(3) COMMENT 'This is the primary key for code types',
                       englishDescription varchar(100) NOT NULL COMMENT 'English description',
                       frenchDescription varchar(100) DEFAULT NULL COMMENT 'French description',
                       createdDateTime datetime DEFAULT NULL,
                       createdUserId varchar(20) DEFAULT NULL,
                       updatedDateTime datetime DEFAULT NULL,
                       updatedUserId varchar(20) DEFAULT NULL
) COMMENT 'This tables holds the code types that are available for the application';

ALTER TABLE CodeType
    ADD PRIMARY KEY (CodeTypeId);

INSERT INTO CodeType (CodeTypeId, englishDescription, frenchDescription, createdDateTime, createdUserId, updatedDateTime, updatedUserId) VALUES
    (1, 'User Types', 'User Types FR', sysdate(), '', CURRENT_TIMESTAMP, '');
INSERT INTO CodeType (CodeTypeId, englishDescription, frenchDescription, createdDateTime, createdUserId, updatedDateTime, updatedUserId) VALUES
    (2, 'Squash Technical Types', 'Squash Technical Types FR', sysdate(), '', CURRENT_TIMESTAMP, '');



CREATE TABLE CodeValue (
                           codeTypeId int(3) NOT NULL COMMENT 'see code_type table',
                           codeValueSequence int(3) NOT NULL,
                           englishDescription varchar(100) NOT NULL COMMENT 'English description',
                           englishDescriptionShort varchar(20) NOT NULL COMMENT 'English abbreviation for description',
                           frenchDescription varchar(100) DEFAULT NULL COMMENT 'French description',
                           frenchDescriptionShort varchar(20) DEFAULT NULL COMMENT 'French abbreviation for description',
                           sortOrder int(3) DEFAULT NULL COMMENT 'Sort order if applicable',
                           createdDateTime datetime DEFAULT NULL,
                           createdUserId varchar(20) DEFAULT NULL,
                           updatedDateTime datetime DEFAULT NULL,
                           updatedUserId varchar(20) DEFAULT NULL
) COMMENT='This will hold code values for the application.';

ALTER TABLE CodeValue
    ADD PRIMARY KEY (CodeTypeId, codeValueSequence);

INSERT INTO CodeValue (codeTypeId, codeValueSequence, englishDescription, englishDescriptionShort, frenchDescription, frenchDescriptionShort, createdDateTime, createdUserId, updatedDateTime, updatedUserId) VALUES
    (1, 1, 'General', 'General', 'GeneralFR', 'GeneralFR', '2015-10-25 18:44:37', 'admin', '2015-10-25 18:44:37', 'admin');
INSERT INTO CodeValue (codeTypeId, codeValueSequence, englishDescription, englishDescriptionShort, frenchDescription, frenchDescriptionShort, createdDateTime, createdUserId, updatedDateTime, updatedUserId) VALUES
    (1, 2, 'Admin', 'Admin', 'Admin', 'Admin', '2015-10-25 18:44:37', 'admin', '2015-10-25 18:44:37', 'admin');
INSERT INTO CodeValue (codeTypeId, codeValueSequence, englishDescription, englishDescriptionShort, frenchDescription, frenchDescriptionShort, createdDateTime, createdUserId, updatedDateTime, updatedUserId) VALUES
    (2, 1, 'Forehand Drives', 'FH Drives', 'Forehand DrivesFR', 'FH DrivesFR', '2024-09-13 18:44:37', 'admin', '2024-09-13 18:44:37', 'admin');
INSERT INTO CodeValue (codeTypeId, codeValueSequence, englishDescription, englishDescriptionShort, frenchDescription, frenchDescriptionShort, createdDateTime, createdUserId, updatedDateTime, updatedUserId) VALUES
    (2, 2, 'Backhand Drives', 'BH Drives', 'Backhand DrivesFR', 'BH DrivesFR', '2024-09-13 18:44:37', 'admin', '2024-09-13 18:44:37', 'admin');


