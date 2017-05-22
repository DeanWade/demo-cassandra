package com.example.cassandra.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories("com.example.cassandra.repository")
public class CassandraConfig {

}
