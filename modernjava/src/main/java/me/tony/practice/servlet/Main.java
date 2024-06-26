package me.tony.practice.servlet;

import io.undertow.Undertow;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.ServletContainer;
import io.undertow.servlet.api.ServletInfo;

public class Main {
    public static void main(String[] args) {
        var builder = Undertow.builder().addHttpListener(8080, "localhost");
        var sc = ServletContainer.Factory.newInstance();
        DeploymentInfo di = new DeploymentInfo();

        var servletInfo = new ServletInfo("abc", MyServlet.class);

    }
}
