package com.springbootdatabse.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springbootdatabse.database.beandetails.BeanDetails;

@Repository
public interface UseRepository extends JpaRepository<BeanDetails, String>{
	//@Query(value="select * from Bean where username=?1 && password=?2", nativeQuery=true)
	//@Query("SELECT username FROM Bean b WHERE b.username=:username and b.password=:password")
	
	@Query(value="select * from BeanDetails inner join Bean "
			+ "on Bean.username=BeanDetails.username where Bean.username=?1 and Bean.password=?2 "
			+ "and BeanDetails.username=?1", nativeQuery=true)
//	@Query(value="SELECT Bean.username,BeanDetails.username, BeanDetails.name ,BeanDetails.mobile_number "
//			+ "FROM BeanDetails INNER JOIN Bean ON Bean.username = BeanDetails.username "
//			+"WHERE Bean.username =?1 AND Bean.password =?2 AND BeanDetails.username =?1",nativeQuery=true)

	List<BeanDetails> findBeanByUsername(String username,String password);
	
	
}
