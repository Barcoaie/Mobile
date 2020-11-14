import 'package:flutter/cupertino.dart';
import 'package:lab3_ma/Domain/Vegetable.dart';

class VegetableRepo {
  static final VegetableRepo _vegetableRepo = VegetableRepo._private();
  VegetableRepo._private();
  factory VegetableRepo() => _vegetableRepo;
  final List<Vegetable> vegetables = new List<Vegetable>();

  void addVegetable(vegetable) {
    this.vegetables.add(vegetable);
  }

  void removeVegetable(vegetable) {
    vegetables.remove(vegetable);
  }

  void updateVegetable(index, vegetable) {
    vegetables.removeAt(index);
    vegetables.insert(index, vegetable);
  }

  List<Vegetable> getVegetables() {
    return vegetables;
  }
}