package me.tony.practice.job;

public sealed interface Job permits Designer, Engineer {

    String named();

    int salary();
}
