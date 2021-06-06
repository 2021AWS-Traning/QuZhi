console.log('Loading function');

const AWS = require('aws-sdk');

exports.handler = async (event, context) => {
  AWS.config.update({region: 'ap-southeast-2'});
  const s3 = new AWS.S3({apiVersion: '2006-03-01'});
  const params = {
    Bucket: 'qz-source-bucket',
    Key: '1.jpeg',
  };
  try {
    let data = await s3.getObject(params).promise()
    console.log('data:', data);
    const {Body}=data;
    const param = {
      Bucket: 'qz-target-bucket',
      Key: '1.jpeg',
      Body: Body
    }
    await s3.putObject(param).promise()
    return data;
  } catch (err) {
    console.log(err);
    throw new Error(err);
  }
};
