package client;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.Session;
import util.HibernateUtil;

import java.sql.CallableStatement;
import java.sql.Types;
import java.util.concurrent.atomic.AtomicReference;


public class CallStoredProcedureInHibernateClientTest {

	public static void main(String[] args) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			int personId = 2;
			final AtomicReference<Integer> phoneCount = new AtomicReference<>();
			session.doWork( connection -> {
				try (CallableStatement callableStatement = connection.prepareCall(
						"{ ? = call fn_count_phones(?) }" )) {
					callableStatement.registerOutParameter( 1, Types.INTEGER );
					callableStatement.setInt( 2, personId);
					callableStatement.execute();
					phoneCount.set(callableStatement.getInt(1) );
				}
			} );
			if(phoneCount != null){
				System.out.println("Phone Count:"+phoneCount.get());
			}
		}
	}
}