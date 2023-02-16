package de.bcxp.challenge.mapper;

import de.bcxp.challenge.Info;

import java.util.ArrayList;
import java.util.List;

public interface InfoMapper<T extends Info> {

    ArrayList<T> mapLines(List<String[]> lines);
}
