package com.webbfontaine.kotlin.domain

import javax.persistence.*

@Entity
class Role(var roleId: String,
           var description: String,
           @OneToMany var user: MutableList<User>,
           @Id @GeneratedValue var id: Long?=null)

@Entity
class User(var username: String,
           var firstName: String,
           var lastName: String,
           @Id @GeneratedValue var id: Long?=null)

