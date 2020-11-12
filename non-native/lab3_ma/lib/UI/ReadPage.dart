import 'package:flutter/material.dart';
import 'package:lab3_ma/Domain/Vegetable.dart';
import 'package:lab3_ma/Repository/VegetableRepo.dart';

class ReadPage extends StatefulWidget {
  ReadPage({Key key, this.title}): super(key: key);

  final String title;

  @override
  _ReadPageState createState() => _ReadPageState();
}

class _ReadPageState extends State<ReadPage> {

  @override
  Widget build(BuildContext context) {
    VegetableRepo vegetableRepo = ModalRoute.of(context).settings.arguments;
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: ListView.separated(
        itemCount: vegetableRepo.vegetables.isEmpty ? null : vegetableRepo.vegetables.length,
        itemBuilder: (context, index) {
          if (vegetableRepo.vegetables.isEmpty) {
            return ListTile();
          }
          else
            return ListTile(
              title: Text(vegetableRepo.vegetables[index].name),
          );
        },
        separatorBuilder: (context, index) {
          return Divider();
        },
      ),
    );
  }
}
