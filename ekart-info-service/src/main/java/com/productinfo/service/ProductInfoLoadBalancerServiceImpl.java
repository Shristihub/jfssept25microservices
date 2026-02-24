package com.productinfo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.productinfo.model.Product;


@Service
public class ProductInfoLoadBalancerServiceImpl implements IProductInfoService{
	
	private final String BASEURL= "http://product-catalog/catalog-service/v1/products";
	private RestClient restClient;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	//select the interface not the class
	@Autowired
	private DiscoveryClient discoveryClient;
	
	
	public ProductInfoLoadBalancerServiceImpl(RestClient.Builder builder) {
		this.restClient = builder.build(); //returns a restclient object
	}

	@Override
	public List<Product> getAllProducts() {
//		http://localhost:8081/catalog-service/v1/products
		ResponseEntity<List<Product>> responseEntity =  restClient
		   .get()
		   .uri(BASEURL)
		   .retrieve()
		   .toEntity(new ParameterizedTypeReference<>() {});
		 // pass the other service application name
		ServiceInstance instance = loadBalancerClient.choose("product-catalog");
		System.out.println(".........details..........");
		System.out.println("port "+instance.getPort());
		System.out.println("scheme "+instance.getScheme());
		System.out.println("serviceId"+instance.getServiceId());
		System.out.println("instanceId "+instance.getInstanceId());
		System.out.println("host "+instance.getHost());
		System.out.println("metadata "+instance.getMetadata());
		return responseEntity.getBody();
	}
	
//    http://localhost:8081/catalog-service/v1/products/productId/1
    public Product getById(int productId) {
    	
    	Product product = restClient
				   .get()
				   .uri(BASEURL.concat("/productId/{productId}"),productId)
				   .retrieve()
				   .body(Product.class);
    	List<ServiceInstance> serviceInstances = discoveryClient.getInstances("product-catalog");
    	serviceInstances.forEach(instance->{
    		System.out.println(".........details..........");
    		System.out.println("port "+instance.getPort());
    		System.out.println("scheme "+instance.getScheme());
    		System.out.println("serviceId "+instance.getServiceId());
    		System.out.println("instanceId "+instance.getInstanceId());
    		System.out.println("host "+instance.getHost());
    		System.out.println("metadata "+instance.getMetadata());
    		
    	});
    	return product;
}

	@Override
	public List<Product> getProductsByBrand(String brand) {
//		 http://localhost:8081/catalog-service/v1/products/brand/Samsung
		ResponseEntity<List<Product>> responseEntity =  restClient
				   .get()
				   .uri(BASEURL.concat("/brand/{brand}"),brand)
				   .retrieve()
				   .toEntity(new ParameterizedTypeReference<>() {});
				return responseEntity.getBody();
	}

	@Override
	public List<Product> getProductsByCategory(String category) {
//		 http://localhost:8081/catalog-service/v1/products/category?category=electronics
		return restClient
				   .get()
				   .uri(BASEURL.concat("/category?category={category}"),category)
				   .retrieve()
				   .body(new ParameterizedTypeReference<>() {});
	}

	@Override
	public List<Product> getProductsByCatLessPrice(String category, double price) {
//		http://localhost:8081/catalog-service/v1/products/category/Electronics/price/20000
		ResponseEntity<List<Product>> responseEntity =  restClient
		 .get().uri(BASEURL
		  .concat("http://localhost:8081/catalog-service/v1/products/category/{category}/price/{price}"),category,price)
		 .retrieve()
				   .toEntity(new ParameterizedTypeReference<>() {});
				return responseEntity.getBody();
	}

}
