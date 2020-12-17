package com.manish.model

import org.hibernate.annotations.ColumnDefault
import javax.persistence.*

@Entity
@Table(name = "department")
data class Department(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var deptID: Int,
        var deptName: String,
        @Column(columnDefinition = "int default 1", insertable = false)
        //@ColumnDefault(value="1")
        var status: Int = 1
) {}