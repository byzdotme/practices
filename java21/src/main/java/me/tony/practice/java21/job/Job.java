package me.tony.practice.java21.job;

public sealed interface Job permits Designer, Engineer {

    String named();

    int salary();
}
