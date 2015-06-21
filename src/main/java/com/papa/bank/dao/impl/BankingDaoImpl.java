package com.papa.bank.dao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.papa.bank.dao.BankingDao;
import com.papa.bank.domain.Transactions;
import com.papa.bank.domain.User;
import com.papa.bank.request.TransferRequestBean;

@Repository
public class BankingDaoImpl implements BankingDao{

@Autowired
private SessionFactory sessionFactory;

	@Transactional
	public User authenticateUsers(User user) {
		Session session = sessionFactory.getCurrentSession();

		//Secure Usage
//		SQLQuery query = session.createSQLQuery("select * from Users where userName like :userId and password like :password");
//		query.setString("userId", user.getUserId());
//		query.setString("password", user.getPassword());
//		Object userDetail = query.uniqueResult();

		SQLQuery query = session.createSQLQuery("select * from Users where userName like " + "'" + user.getUserName() + "'" + " and password like " + "'" + user.getPassword() + "'");
		query.addEntity(User.class);
		List<User> userDetail = query.list();
		return userDetail.get(0);


	}

	@Transactional
	public List<Transactions> getTransactionDetails(String userName) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Transactions.class);
		criteria.add(Restrictions.eq("userName", userName));
		List<Transactions> transactionList = criteria.list();
		return transactionList;
	}

	@Transactional
	public User getAccountDetails(String userName) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userName", userName));
		List<User> userAccount = criteria.list();
		if (CollectionUtils.isNotEmpty(userAccount)) {
			return userAccount.get(0);
		} else {
			return null;
		}

	}

	@Transactional
	public User transferFunds(TransferRequestBean transfer, String userName) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userName", userName));
		List<User> userAccount = criteria.list();
		User user = null;
		User transferUser = null;
		if (CollectionUtils.isNotEmpty(userAccount)) {
			user = userAccount.get(0);
			user.setBalance(user.getBalance() - transfer.getAmount());
		}
		session.saveOrUpdate(user);
		Criteria transferCriteria = session.createCriteria(User.class);
		transferCriteria.add(Restrictions.eq("accNo", transfer.getAccountNo()));
		List<User> transferAccount = transferCriteria.list();
		if (CollectionUtils.isNotEmpty(transferAccount)) {
			transferUser = transferAccount.get(0);
			transferUser.setBalance((transferUser.getBalance() + transfer.getAmount()));
		}
		session.saveOrUpdate(transferUser);
		return transferUser;
	}

}
