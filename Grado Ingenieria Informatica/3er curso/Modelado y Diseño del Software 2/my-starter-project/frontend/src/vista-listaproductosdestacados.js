import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-combo-box/src/vaadin-combo-box.js';
import './vista-producto.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

class VistaListaproductosdestacados extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="height: 100%; padding: var(--lumo-space-m); width: 100%;">
 <vaadin-horizontal-layout theme="spacing" id="cabecera_lista_productos" style="flex-shrink: 1; flex-grow: 0; width: 100%;">
  <h2 id="titulo_lista_productos" style="align-self: center;">Productos</h2>
  <vaadin-combo-box id="combobox_lista_productos" style="align-self: center;"></vaadin-combo-box>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" id="horizontalFuera">
  <vaadin-horizontal-layout class="content" style="flex-grow: 1; align-self: stretch; justify-content: flex-start; flex-wrap: nowrap;" id="cuadro_lista_boton" theme="spacing-l"></vaadin-horizontal-layout>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-listaproductosdestacados';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaListaproductosdestacados.is, VistaListaproductosdestacados);
