import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import './vista-productoresultado.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class VistaListaresultadosbusquedaadministrador extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%;" theme="spacing">
 <vaadin-horizontal-layout theme="spacing" id="lista_elementos_producto_resultado" style="justify-content: center; flex-wrap: wrap; align-self: stretch; width: 100%;">
  
 </vaadin-horizontal-layout>
 <vaadin-button id="boton_aniadir_producto" style="margin: var(--lumo-space-xl);">
  Añadir Producto
 </vaadin-button>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-listaresultadosbusquedaadministrador';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaListaresultadosbusquedaadministrador.is, VistaListaresultadosbusquedaadministrador);
