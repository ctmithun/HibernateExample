CREATE TABLE `employee` (                                
`id` int(11) NOT NULL AUTO_INCREMENT,                  
`emp_name` varchar(100) DEFAULT NULL,                  
`emp_address` varchar(500) DEFAULT NULL,               
`emp_mobile_nos` varchar(100) DEFAULT NULL, 
`emp_salary` int(12) DEFAULT NULL,            
PRIMARY KEY (`id`)                                     
) ENGINE=InnoDB DEFAULT CHARSET=latin1;