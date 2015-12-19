package base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.apache.poi.ss.formula.functions.FinanceLib;

import domain.RateDomainModel;
import util.HibernateUtil;

public class RateDAL {
	
	public static double getRate(int GivenCreditScore) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		RateDomainModel rateGet = null;
		double interestRate = 0.00;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("from " + RateDomainModel.class.getName() + " where MinCreditScore = :MINCREDITSCORE");
			query.setParameter("MINCREDITSCORE", GivenCreditScore);
			List<?> creditlist = query.list();
			rateGet = (RateDomainModel)creditlist.get(0);
			interestRate = rateGet.getInterestRate();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return interestRate;
	}



}