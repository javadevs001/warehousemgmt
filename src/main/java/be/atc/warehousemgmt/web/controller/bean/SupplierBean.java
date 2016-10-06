package be.atc.warehousemgmt.web.controller.bean;

import be.atc.warehousemgmt.model.entity.Person;
import be.atc.warehousemgmt.model.entity.PersonType;


/**
 * Created by Maximilien on 21/08/16.
 */
public class SupplierBean {

    private Long personId;
    private String companyName;
    private String email;
    private String phone;
    private String fax;
    private String addressCity;
    private String addressPostCode;
    private String addressStreet;
    private String addressNumber;
    private String addressBox;
    private String tva;
    private String personType;

    public SupplierBean() {
    }

    public static SupplierBean of(Person person) {
        SupplierBean supplierBean = new SupplierBean();
        supplierBean.setAddressBox(person.getAddressBox());
        supplierBean.setAddressCity(person.getAddressCity());
        supplierBean.setAddressNumber(person.getAddressNumber());
        supplierBean.setAddressPostCode(person.getAddressPostCode());
        supplierBean.setAddressStreet(person.getAddressStreet());
        supplierBean.setCompanyName(person.getCompanyName());
        supplierBean.setEmail(person.getEmail());
        supplierBean.setFax(person.getFax());
        supplierBean.setPersonId(person.getPersonId());
        supplierBean.setPhone(person.getPhone());
        supplierBean.setTva(person.getTva());
        supplierBean.setPersonType(person.getPersonType().name());

        return supplierBean;
    }

    public Person prepareForCreation() {
        Person persons = new Person();
        persons.setPersonType(PersonType.Supplier);
        persons.setAddressBox(getAddressBox());
        persons.setAddressCity(getAddressCity());
        persons.setAddressNumber(getAddressNumber());
        persons.setAddressPostCode(getAddressPostCode());
        persons.setAddressStreet(getAddressStreet());
        persons.setCompanyName(getCompanyName());
        persons.setEmail(getEmail());
        persons.setFax(getFax());
        persons.setPersonId(getPersonId());
        persons.setPhone(getPhone());
        persons.setTva(getTva());
        return persons;
    }

    public Person prepareForUpdate(Person supplier) {
        supplier.setAddressNumber(getAddressNumber());
        supplier.setAddressBox(getAddressBox());
        supplier.setAddressCity(getAddressCity());
        supplier.setAddressPostCode(getAddressPostCode());
        supplier.setAddressStreet(getAddressStreet());
        supplier.setCompanyName(getCompanyName());
        supplier.setEmail(getEmail());
        supplier.setFax(getFax());
        supplier.setPhone(getPhone());
        supplier.setTva(getTva());
        return supplier;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressPostCode() {
        return addressPostCode;
    }

    public void setAddressPostCode(String addressPostCode) {
        this.addressPostCode = addressPostCode;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getAddressBox() {
        return addressBox;
    }

    public void setAddressBox(String addressBox) {
        this.addressBox = addressBox;
    }

    public String getTva() {
        return tva;
    }

    public void setTva(String tva) {
        this.tva = tva;
    }

}
