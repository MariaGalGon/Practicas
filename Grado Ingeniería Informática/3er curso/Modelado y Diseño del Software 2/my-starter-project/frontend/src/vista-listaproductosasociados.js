import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-list-box/src/vaadin-list-box.js';
import '@vaadin/vaadin-item/src/vaadin-item.js';
import './vista-productoasociado.js';

class VistaListaproductosasociados extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%;" id="vaadinVerticalLayout">
 <vaadin-list-box id="lista_productos_asociados" style="align-self: stretch; width: 100%; flex-grow: 1;">
  
 </vaadin-list-box>
 <vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout" style="margin: var(--lumo-space-s);">
  <vaadin-button id="boton_aniadir">
   Añadir
  </vaadin-button>
  <vaadin-button id="boton_eliminar">
   Eliminar
  </vaadin-button>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-listaproductosasociados';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaListaproductosasociados.is, VistaListaproductosasociados);
