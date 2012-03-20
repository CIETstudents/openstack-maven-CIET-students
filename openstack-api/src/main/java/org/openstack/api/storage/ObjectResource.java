package org.openstack.api.storage;

import java.io.InputStream;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.Request.RequestBuilder;

import org.openstack.api.common.Resource;
import org.openstack.api.identity.TenantResource;
import org.openstack.model.storage.SwiftObjectProperties;

public class ObjectResource  extends Resource {
	
	private TenantResource t = null; //new TenantResource();
	
	
	public ObjectResource(Target target) {
		super(target);
	}
	
	
	public void delete() {
		target.request().delete();
	}

	public InputStream openStream() {
		RequestBuilder request = buildDownloadRequest();

		return null;//request.get(InputStream.class);
	}

	public RequestBuilder buildDownloadRequest() {
//		RequestBuilder builder = resource();
//		builder.setMethod("GET");
//		return builder;
		return null;
	}

	public SwiftObjectProperties metadata() {
//		HeadResponse response = resource().head();
//		int httpStatus = response.getStatus();
//		if (httpStatus == 200) {
//			SwiftObjectProperties properties = SwiftHeaderUtils.unmarshalHeaders(response);
//			return properties;
//		}
//
//		if (httpStatus == 404) {
//			throw new OpenstackNotFoundException("Object not found");
//		}
//
//		throw new OpenstackException("Unexpected HTTP status code: " + httpStatus);
		return null;
	}

	public void updateMetadata(SwiftObjectProperties changeProperties) {
//		RequestBuilder builder = resource();
//		builder = SwiftHeaderUtils.setHeadersForProperties(builder, changeProperties);
//		builder.post();
	}

}