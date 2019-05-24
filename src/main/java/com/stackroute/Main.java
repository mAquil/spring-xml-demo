package com.stackroute;

import com.stackroute.domain.Movie;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Main {
    public static void main(String[] args) {

        ClassPathResource resource = new ClassPathResource("beans.xml");
        BeanFactory factory=new XmlBeanFactory(resource);
        Movie movie1=(Movie)factory.getBean("movie");
        System.out.println(movie1.getActor().getName()+" acted in " +movie1.getMovieName());

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Movie movie= (Movie) context.getBean("movie");
        System.out.println(movie.getActor().getName()+ " acted in: "+ movie.getMovieName());

        BeanDefinitionRegistry beanDefinitionRegistry = new DefaultListableBeanFactory();
        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanDefinitionRegistry);
        beanDefinitionReader.loadBeanDefinitions(new ClassPathResource("beans.xml"));
        Movie movie2=(Movie) ((DefaultListableBeanFactory) beanDefinitionRegistry).getBean("movie");
        System.out.println(movie2.getActor().getName()+ " acted in: " + movie2.getMovieName());

        //testing bean scope
        ApplicationContext context1 = new ClassPathXmlApplicationContext("beans.xml");
        Movie movie3 = (Movie) context1.getBean("movie");
        Movie movie4 = (Movie) context1.getBean("movie");
        System.out.println(movie3==movie4);

    }
}
