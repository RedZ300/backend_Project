INSERT INTO BUILDING(id, name, FLOOR_COUNT, ADRESS) VALUES(1, 'Espace Fauriel', 6, '29 Rue Pierre et Dominique Ponchardier, 42100 Saint-Étienne');
INSERT INTO BUILDING(id, name, FLOOR_COUNT, ADRESS) VALUES(2, 'Cours Fauriel', 3, '158 Cr Fauriel, 42100 Saint-Étienne');
INSERT INTO BUILDING(id, name, FLOOR_COUNT, ADRESS) VALUES(3, 'Crous Metare', 3, '25 Rue du Dr Paul Michelon, 42100 Saint-Étienne');

INSERT INTO ROOM(id, name, floor, current_temperature, target_temperature, building_id) VALUES(1, 'Room1', 1, 22.3, 20.0, 1);
INSERT INTO ROOM(id, name, floor, current_temperature, target_temperature, building_id) VALUES(2, 'Room2', 3, 31.5, 25.5, 1);
INSERT INTO ROOM(id, name, floor, current_temperature, target_temperature, building_id) VALUES(3, 'Room3', 1, 31.5, 15.5, 3);
INSERT INTO ROOM(id, name, floor, current_temperature, target_temperature,building_id) VALUES(4, 'Room4', 1, 26.8, 15.5, 2);
INSERT INTO ROOM(id, name, floor, current_temperature, target_temperature, building_id) VALUES(5, 'Room5', 1, 31.5, 25.5, 1);
INSERT INTO ROOM(id, name, floor, current_temperature, target_temperature, building_id) VALUES(6, 'Room6', 2, 42.5, 37.5, 2);

INSERT INTO HEATER(id, heater_status, name, power, room_id) VALUES(1, 'ON', 'Heater1', 2000, 1);
INSERT INTO HEATER(id, heater_status, name, power, room_id) VALUES(2, 'OFF', 'Heater2', 3500, 3);
INSERT INTO HEATER(id, heater_status, name, power, room_id) VALUES(3, 'OFF', 'Heater3', 2200, 4);
INSERT INTO HEATER(id, heater_status, name, power, room_id) VALUES(4, 'OFF', 'Heater4', 3000, 5);
INSERT INTO HEATER(id, heater_status, name, power, room_id) VALUES(5, 'ON', 'Heater5', 2000, 2);
INSERT INTO HEATER(id, heater_status, name, power, room_id) VALUES(6, 'ON', 'Heater6', null, 6);
INSERT INTO HEATER(id, heater_status, name, power, room_id) VALUES(7, 'ON', 'Heater7', 2020, 1);
INSERT INTO HEATER(id, heater_status, name, power, room_id) VALUES(8, 'OFF', 'Heater8', null, 6);

INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(1, 'CLOSED', 'Window 1', 1);
INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(2, 'CLOSED', 'Window 2', 1);
INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(13, 'OPEN', 'Window 13', 1);
INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(3, 'OPEN', 'Window 3', 2);
INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(4, 'CLOSED', 'Window 4', 2);
INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(5, 'OPEN', 'Window 5', 3);
INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(6, 'CLOSED', 'Window 6', 3);
INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(7, 'OPEN', 'Window 7', 4);
INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(8, 'CLOSED', 'Window 8', 4);
INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(9, 'OPEN', 'Window 9', 5);
INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(10, 'OPEN', 'Window 10', 5);
INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(11, 'OPEN', 'Window 11', 4);
INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(12, 'CLOSED', 'Window 12', 6);
