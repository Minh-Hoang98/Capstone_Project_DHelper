package com.fpt.edu.DomanticHelper.generator;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class IdLocationGenerator implements IdentifierGenerator {

	public int randomId () {
		Random generator = new Random();
		
		return generator.nextInt(999);
		
	}

	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		// TODO Auto-generated method stub
		int value = new IdLocationGenerator().randomId();
		if (value < 10) {
			return "LOC00"+String.valueOf(value) ;
		} else if (value < 100) {
			return "LOC0"+String.valueOf(value) ;
		}
			return "LOC"+String.valueOf(value) ;
	}
	public static void main(String[] args) {
		System.out.println(new IdLocationGenerator().generate(null, args));
	}
}