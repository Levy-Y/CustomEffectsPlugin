# Numbness Effect

## Overview

A basic Minecraft plugin that adds a new "effect" to your server, called numbness.

## Features

- **Numbness Effect**: Grants temporary invincibility to players, with a twist. Any damage taken during the effect's duration is recorded and applied once the effect ends.
- **Custom Death Messages**: If a player dies due to the damage accumulated during the numbness effect, a custom death message is displayed.
- **Command Usage**: Numbness effect can be applied to any player using a simple command.

## Installation

1. Download the plugin JAR file from the Releases section.
2. Place the downloaded JAR file in your server's `plugins` directory.
3. Restart your server, or load the plugin dynamically if your server supports it.

## Usage

To apply the numbness effect to a player, use the following command:

- /numbness `<player>`

Replace `<player>` with the actual name of the player you wish to affect.

## Permissions

Currently, the `/numbness` command can be used by server operators. Future versions may include configurable permissions for finer control.

## Configuration

This plugin does not require any configuration and does not have a configuration file. It is designed to work out-of-the-box.

## Known Issues

- The numbness effect does not account for damage modifiers from armor or enchantments when applying recorded damage.

## Contributing

Contributions are welcome! If you have ideas for improvements or have discovered bugs, please open an issue or submit a pull request.

## Acknowledgments

Inspired by [doctor4t](https://www.youtube.com/watch?v=6fby-ANNjVw&t=284s)'s numbness effect. Special thanks to the Minecraft and Spigot/Paper communities for their continuous support and resources.
