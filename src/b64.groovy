def s = 'iVBORw0KGgoAAAANSUhEUgAAAEgAAABICAMAAABiM0N1AAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAACrUExURUdwTJBOWRQYS3cWGYAWGYpYZWdumXMoN50qMIAXGr1rb38aHncZHc1rb290mI92jXNxk7xxdm5yl24gLrhwdx8pZyovZPJKTs0lKsgiJu5ITdMrMNgxNuY/Q+tESeA4PURQlSw3fT9LjSIudMc0OJoeI6wsMTZBhh0maLYeIlpgk4RPe09VkNY9QsVQWBQdU3d9pt5YXHc1XLdSYpqevc3P27a5zu7v8EwrXlbja1EAAAAXdFJOUwA8qVmrH/4IoPrr2Ij9ylqTj+hyx6ylHtWyxAAAAv9JREFUWMPt1+lS4kAUBWAzJGEQhrBNZSFrZ5PQwSig8/5PNrf7BtLZBNH5M8XR0tLCz3MvIQkPD/fcc8//neFQkTSJfSrKcHiToCiaNp+vVo/nrOZzTfkUBgYQj4+/MDvMfrffM02p/tlHPSRtNpuuUHhhyVkiDPd+nv5+uJx1NSyNRVEU6pYJ+otluY7n2fZ6bRgmSxTlUVJBv1M6nc00WB8skH2RNEZMFwuVJcuyrYVxnTpkrm0R+vEUUJqpi8ViyrMoBY5QSn0fIdetQxvTNOrQ81OQEgIYplD5N05gGOS2oHaj56cwDIMgTYEjtDi+ZfCd+FXK0RDyAFr3QUxiFmiBejww0hewxo7sUyOjDXEp4BQtVIDoofCJ34Sas/U1CikbkM2YFu8HIkA6fPBGNajdKMRG6lsR8F2lRD0U5GIjo7tREKrHgjMQX1w3NIK0D6QeKAxJRrERf9pqo3HocqOQzRYE5Vxpdiwqhp4g/dpGwZkih/qRdD0UVscRpn5E3twIIXKarBMyLjUKgoKm5BsaEXitqSD5t++oHKx4fyPijmi23eufg0I+mXo4kHI2MLb73Qv2uQzJcfz6p6qECt3WjCshONclSfx6Cgi73HWtmnItZMDZam3bee558GDHcVka1HVQKdm2xygusZPHDZCBkOehhI2s2yGxkfWFRvC474Fwtk7o4vmotSOnaiRSF8/Z3Y1OUmnoXEVo3XMVaT9rTvWsocAl3RIukFc0qi/JQkLvvKyZ1xxH1WyW1Xd97IcaT5tr1VJd+0+XbGP9ASQ2EqTuu5E2ZLYbnbfkcgYL5bYdIbPhL/UuqHNJLmewDL93TJJNErNsIHDz1wM1jyQciBMJGIwYVYlj+FUTQsmuVXKc8haWE6PReDyW5QmPLMtjTsUCNGI1yy3hkZR7dpOQl4OBcLs/ZO8BBhPQRIjJbOTIjM5JcJAYiMkSiO67cUVaDs4/SBO5nBiSxLhKtgxm9BJ97oSPjMFVLD9niG97pAHm5nc+99xzz7/OXyEuKG7iqZKOAAAAAElFTkSuQmCC'
 
//String encoded = s.bytes.encodeBase64().toString()
//assert 'QXJnaCwgR3Jvb3Z5IHlvdSBzYXksIG1hdGU/' == encoded

//String encoded = 

byte[] decoded = s.decodeBase64()
def f = new File("emoji-2775.png") 
f << decoded

//assert s == new String(decoded)