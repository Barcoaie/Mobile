import 'package:flutter/material.dart';
import 'package:lab3_ma/Domain/Vegetable.dart';
import 'package:lab3_ma/Repository/VegetableRepo.dart';
import 'package:lab3_ma/UI/ReadDetailPage.dart';
import 'package:lab3_ma/utils.dart';

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
      body: vegetableRepo.vegetables.isNotEmpty ? ListView.separated(
        itemCount: vegetableRepo.vegetables.length,
        itemBuilder: (context, index) {
          return ListTile(
            title: Text(vegetableRepo.vegetables[index].name),
            onTap: () {
              Navigator.of(context).push(
                  MaterialPageRoute(
                      builder: (context) => ReadDetailPage(title: "Read page - detail",),
                      settings: RouteSettings(arguments: Arguments(vegetableRepo,index))
                  )
              );
            }
          );
        },
        separatorBuilder: (context, index) {
          return Divider();
        },
      ) :
      Center(
        child: Text("Nothing to show!"),
      )
    );
  }
}
