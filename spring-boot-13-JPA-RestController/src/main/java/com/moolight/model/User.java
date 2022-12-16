package com.moolight.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "[user]")
public class User implements Serializable {
  private static final long serialVersionUID = -297553281792804396L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // Mapping thông tin biến với tên cột trong Database
  private int hp;
  private int stamina;

  // Nếu không đánh dấu @Column thì sẽ mapping tự động theo tên biến
  private int atk;
  private int def;
  private int agi;
}
