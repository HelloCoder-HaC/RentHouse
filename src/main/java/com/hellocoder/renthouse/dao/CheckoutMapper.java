package com.hellocoder.renthouse.dao;

import java.util.List;

import com.hellocoder.renthouse.Pojo.Checkout;

public interface CheckoutMapper {
	public void insertcheckout(Checkout checkout);
	public List<Checkout> getallcheckout();
	public void deletecheckout(Integer id);
}
