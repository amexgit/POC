insert into Approver (approver_Id,name,email_id,supervisor) values('A1','N1','n1@cts.com','A4') ;
insert into Approver (approver_Id,name,email_id,supervisor) values('A2','N2','n2@cts.com','NA') ;
insert into Approver (approver_Id,name,email_id,supervisor) values('A3','N3','n3@cts.com','A2') ;
insert into Approver (approver_Id,name,email_id,supervisor) values('A4','N4','n4@cts.com','A2') ;

insert into Ticket (ticket_id,requestor_id,approver_id,priority,category,status) values('T1','R1','A1','HIGH','LEAVE','PENDING');
insert into Ticket (ticket_id,requestor_id,approver_id,priority,category,status) values('T2','R2','A1','MEDIUM','LEAVE','APPROVED');
insert into Ticket (ticket_id,requestor_id,approver_id,priority,category,status) values('T3','R3','A1','LOW','LEAVE','HOLD');
insert into Ticket (ticket_id,requestor_id,approver_id,priority,category,status) values('T4','R4','A2','HIGH','LEAVE','REVERT');
insert into Ticket (ticket_id,requestor_id,approver_id,priority,category,status) values('T5','R5','A3','HIGH','LEAVE','APPROVED');