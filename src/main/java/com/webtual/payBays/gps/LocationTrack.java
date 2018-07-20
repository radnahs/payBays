package com.webtual.payBays.gps;

import java.io.File;
import java.io.IOException;

import com.maxmind.geoip.Location;
import com.maxmind.geoip.LookupService;

public class LocationTrack {

	public static void main(String[] args) {
		LocationTrack obj = new LocationTrack();
		ServerLocation location = obj.getLocation("192.168.43.93");
		System.out.println(location);
	}

	public ServerLocation getLocation(String ipAddress) {
		File file = new File("D:\\Projects\\WebApplications\\payBays\\trunk\\src\\main\\resources\\lib\\GeoLiteCity.dat");
		return getLocation(ipAddress, file);
	}

	public ServerLocation getLocation(String ipAddress, File file) {
		ServerLocation serverLocation = null;
		try {
			serverLocation = new ServerLocation();

			LookupService lookup = new LookupService(file, LookupService.GEOIP_MEMORY_CACHE);
			Location locationServices = lookup.getLocation(ipAddress);
 
			serverLocation.setCountryCode(locationServices.countryCode);
			serverLocation.setCountryName(locationServices.countryName);
			serverLocation.setRegion(locationServices.region);
			//serverLocation.setRegionName(regionName.regionNameByCode(locationServices.countryCode, locationServices.region));
			serverLocation.setCity(locationServices.city);
			serverLocation.setPostalCode(locationServices.postalCode);
			serverLocation.setLatitude(String.valueOf(locationServices.latitude));
			serverLocation.setLongitude(String.valueOf(locationServices.longitude));

		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		return serverLocation;

	}

	/*public static void main1(String[] args) {
		try {
			LookupService cl = new LookupService(
					"D:\\Projects\\WebApplications\\payBays\\trunk\\src\\main\\resources\\lib\\GeoLiteCity.dat",
					LookupService.GEOIP_MEMORY_CACHE | LookupService.GEOIP_CHECK_CACHE);
			Location location = cl.getLocation("192.168.43.93");
			System.out.println(location.city);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

}
