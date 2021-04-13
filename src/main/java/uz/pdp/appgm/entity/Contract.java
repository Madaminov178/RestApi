package uz.pdp.appgm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.appgm.component.GenerateContract;
import uz.pdp.appgm.entity.enums.ContractStatus;
import uz.pdp.appgm.entity.template.AbsEntity;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(GenerateContract.class)
public class Contract extends AbsEntity {
    @Column(nullable = false)
    private String number;//shartnoma raqamini biz generatsiya qilib beramiz
    @ManyToOne(optional = false)
    private Client client;//mashina oluvchi mijoz
    @Enumerated(EnumType.STRING)
    private ContractStatus status;//shartnoma holati biz beramiz
    @ManyToOne(optional = false)
    private Car car;//mijoztanlagan mashina
    @Column(nullable = false)
    private double price;//tanlagan mashinaning shartnoma tuzilgan vaqtdagi narxi
}
