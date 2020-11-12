import 'package:flutter/material.dart';
import 'package:lab3_ma/Repository/VegetableRepo.dart';

class DeletePage extends StatefulWidget {
  DeletePage({Key key, this.title}): super(key: key);

  final String title;

  @override
  _DeletePageState createState() => _DeletePageState();
}

class _DeletePageState extends State<DeletePage> {

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
              title: Text("name = " + vegetableRepo.vegetables[index].name + "; price = " + vegetableRepo.vegetables[index].price.toString()),
            );
        },
        separatorBuilder: (context, index) {
          return Divider();
        },
      ),
    );
  }
}