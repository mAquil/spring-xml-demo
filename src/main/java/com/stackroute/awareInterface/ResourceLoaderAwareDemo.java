package com.stackroute.awareInterface;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ResourceLoaderAwareDemo implements ResourceLoaderAware {

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        Resource banner = resourceLoader.getResource("data.txt");

        InputStream in = null;
        try {
            in = banner.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        while (true) {
            String line = null;
            try {
                line = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (line == null)
                break;
            System.out.println(line);
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

