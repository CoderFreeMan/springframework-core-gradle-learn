package com.practice.sprngframework.core.resources;

import org.springframework.core.io.UrlResource;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class UrlResourceTest {

    public static void main(String[] args) throws IOException, URISyntaxException {
        URI uri = new URI("https://www.baidu.com/");
        UrlResource urlResource = new UrlResource(uri);
        System.out.println(urlResource.isFile());
        System.out.println(urlResource.isOpen());
        System.out.println(urlResource.isReadable());
        System.out.println(urlResource.exists());
        System.out.println("-->" + urlResource);
    }
}
