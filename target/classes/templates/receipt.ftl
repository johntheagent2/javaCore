<!DOCTYPE html>
<html>
<head>
</head>
<body style="font-family: Arial, sans-serif; margin: 0; padding: 0; background-color: #f4f4f4; color: #333;">

<header style="background-color: #2c3e50; color: #fff; padding: 20px; text-align: center;">
    <h1 style="color: #3498db;">Invoice</h1>
</header>

<section>
    <h2>Customer Information:</h2>
    <p>Customer's name: ${customerName}</p>
    <p>Address: ${customerAddress}</p>
</section>

<section>
    <h2>Invoice Information:</h2>
    <p>Invoice Number: ${invoiceNumber}</p>
    <p>Date: ${invoiceDate}</p>
</section>

<table style="width: 100%; border-collapse: collapse; margin-top: 20px;">
    <thead>
    <tr>
        <th style="border: 1px solid #ddd; padding: 12px; text-align: left; background-color: #f2f2f2;">Description</th>
        <th style="border: 1px solid #ddd; padding: 12px; text-align: left; background-color: #f2f2f2;">Quantity</th>
        <th style="border: 1px solid #ddd; padding: 12px; text-align: left; background-color: #f2f2f2;">Price</th>
    </tr>
    </thead>
    <tbody>
    <#list items as item>
        <tr>
            <td style="border: 1px solid #ddd; padding: 12px; text-align: left;">${item.description}</td>
            <td style="border: 1px solid #ddd; padding: 12px; text-align: left;">${item.quantity}</td>
            <td style="border: 1px solid #ddd; padding: 12px; text-align: left;">${item.price}</td>
        </tr>
    </#list>
    </tbody>
</table>

<section>
    <h3 align="right">Total Price: ${totalPrice}</h3>
</section>
<section>

</section>
</body>
</html>
