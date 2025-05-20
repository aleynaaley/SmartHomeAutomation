
# Smart Home Automation System

Akıllı Ev Otomasyon Sistemi, evdeki cihazları merkezi bir şekilde kontrol etmeyi ve farklı senaryolara göre otomatikleştirmeyi amaçlayan Java tabanlı bir projedir. Proje nesne yönelimli tasarım prensiplerine uygun olarak dört temel tasarım deseni (State, Template Method, Composite, Singleton) kullanılarak geliştirilmiştir.(Geliştirilmekte)

## 🔧 Özellikler

- Cihazların (ör. ışık, ısıtıcı) açılıp kapatılmasını sağlayan durum yönetimi (State Pattern)
- Gündüz, gece, tatil ve tatilden dönüş gibi önceden tanımlanmış senaryolar (Template Method Pattern)
- Cihaz gruplarının hiyerarşik yönetimi (Composite Pattern)
- Uygulamanın tüm cihaz kontrolünün tek bir merkezden yönetilmesi (Singleton Pattern)

## 🧱 Proje Yapısı

```text
smart-home-automation/
├── devices/                         # Cihaz sınıfları ve durumları
│   ├── Device.java                  # Soyut cihaz sınıfı
│   ├── Light.java                   # Işık cihazı
│   ├── Heater.java                  # Isıtıcı cihazı
│   └── states/                      # State Pattern bileşenleri
│       ├── DeviceState.java         # Durum arayüzü
│       ├── OnState.java             # Açık durumu
│       └── OffState.java            # Kapalı durumu
│
├── scenarios/                       # Template Method Pattern bileşenleri
│   ├── Scenario.java                # Şablon senaryo sınıfı
│   ├── NightModeScenario.java       # Gece modu senaryosu
│   ├── MorningModeScenario.java     # Gündüz modu senaryosu
│   ├── VacationModeScenario.java    # Tatil modu senaryosu
│   └── ReturnVacationScenario.java  # Tatil dönüşü senaryosu
│
├── composite/                       # Composite Pattern bileşenleri
│   ├── DeviceComponent.java         # Soyut bileşen sınıfı
│   ├── SingleDevice.java            # Tekil cihaz sarmalayıcı
│   └── DeviceGroup.java             # Cihaz grubu sınıfı
│
├── controllers/                     # Singleton kontrol sınıfı
│   └── SmartHomeController.java     # Ana kontrol sınıfı
│
├── Main.java                        # Uygulamanın giriş noktası
Bu yapı, proje içerisindeki tasarım desenlerinin mantıksal yerleşimini ve görevlerini daha iyi anlamanızı sağlar.
```
## 🧠 Kullanılan Tasarım Desenleri

| Tasarım Deseni     | Kullanım Amacı |
|---------------------|----------------|
| State               | Cihazların açık/kapalı gibi durumlarını dinamik olarak yönetmek |
| Template Method     | Farklı senaryo akışlarını ortak yapıyla tanımlamak |
| Composite           | Cihaz ve cihaz gruplarını tekil veya bütünsel olarak yönetmek |
| Singleton           | Tüm sistemi yöneten tek bir kontrolör örneği sağlamak |

## ▶️ Başlarken

Projeyi klonlayarak kendi bilgisayarınızda çalıştırabilirsiniz:

```bash
git clone https://github.com/aleynaaley/smart-home-automation.git
cd smart-home-automation
javac Main.java
java Main
```
## 🚧 Gelecekte Yapılacaklar
Kullanıcı arayüzü (GUI) entegrasyonu

Zamanlayıcı/sensör gibi gerçek zamanlı tetikleyicilerin eklenmesi

Cihaz durumlarının kalıcı olarak veri tabanında saklanması
