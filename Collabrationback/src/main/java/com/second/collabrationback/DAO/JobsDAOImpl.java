package com.second.collabrationback.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.second.collabrationback.Model.Jobs;

public class JobsDAOImpl implements JobsDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public JobsDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Jobs> list() {
		@SuppressWarnings({ "unchecked" })
		List<Jobs> listJobs = (List<Jobs>) sessionFactory.getCurrentSession().createCriteria(Jobs.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listJobs;
	}

	@Transactional
	public Jobs get(String jobsId) {
		String hql = "from Jobs where jobId ='" + jobsId + "'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Jobs> listJobs = (List<Jobs>) query.list();

		if (listJobs != null && !listJobs.isEmpty()) {
			return listJobs.get(0);
		}
		return null;
	}

	@Transactional
	public Jobs saveOrUpdate(Jobs jobs) {
		sessionFactory.getCurrentSession().saveOrUpdate(jobs);
		return jobs;
	}

	@Transactional
	public void delete(String jobsId) {
		Jobs jobstoDelete=new Jobs();
		jobstoDelete.setJobId(jobsId);
		sessionFactory.getCurrentSession().delete(jobstoDelete);

	}

}
