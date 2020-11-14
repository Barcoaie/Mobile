import 'package:flutter/material.dart';
import 'package:lab3_ma/Repository/VegetableRepo.dart';

import '../utils.dart';

class ReadDetailPage extends StatefulWidget {
  ReadDetailPage({Key key, this.title}): super(key: key);

  final String title;

  @override
  _ReadDetailPageState createState() => _ReadDetailPageState();
}

class _ReadDetailPageState extends State<ReadDetailPage>{
  @override
  Widget build(BuildContext context) {
    Arguments args = ModalRoute.of(context).settings.arguments;

    VegetableRepo vegetableRepo = args.vegetableRepo;
    int idx = args.index;

    return Scaffold(
      appBar: AppBar(
        title: Text("Read page - detail"),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: <Widget>[
                Text("name = " + vegetableRepo.vegetables[idx].name),
              ],
            ),
            Text(""),
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: <Widget>[
                Text("price = " + vegetableRepo.vegetables[idx].price.toString()),
              ],
            )
          ],
        )
      ),
    );
    // TODO: implement build
    throw UnimplementedError();
  }
}