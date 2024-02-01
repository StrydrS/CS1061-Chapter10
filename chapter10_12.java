ordinaryCustomers.add("Pranoj");
ordinaryCustomers.add("Rachel");
ordinaryCustomers.add("Pratima");
System.out.println(ordinaryCustomers.remove());
ordinaryCustomers.add("Mohammad");
ordinaryCustomers.add("Jasur");
ordinaryCustomers.add("Shyan");

while(!ordinaryCustomers.isEmpty()) {
    priorityCustomers.add(ordinaryCustomers.remove());
}
while(!priorityCustomers.isEmpty()) {
    System.out.println(priorityCustomers.remove());
}