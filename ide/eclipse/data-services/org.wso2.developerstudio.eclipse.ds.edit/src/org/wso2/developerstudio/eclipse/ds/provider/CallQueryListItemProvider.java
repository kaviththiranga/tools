/**
 * <copyright>
 * </copyright>
 * 
 * $Id$
 */
package org.wso2.developerstudio.eclipse.ds.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.wso2.developerstudio.eclipse.ds.CallQueryList;
import org.wso2.developerstudio.eclipse.ds.DsFactory;
import org.wso2.developerstudio.eclipse.ds.DsPackage;

/**
 * This is the item provider adapter for a
 * {@link org.wso2.developerstudio.eclipse.ds.CallQueryList} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class CallQueryListItemProvider extends ItemProviderAdapter implements
                                                                  IEditingDomainItemProvider,
                                                                  IStructuredItemContentProvider,
                                                                  ITreeItemContentProvider,
                                                                  IItemLabelProvider,
                                                                  IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CallQueryListItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to
	 * deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand},
	 * {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in
	 * {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */

	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			// childrenFeatures.add(DsPackage.Literals.CALL_QUERY_LIST__MIXED);
			childrenFeatures.add(DsPackage.Literals.CALL_QUERY_LIST__CALL_QUERY);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper
		// feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns CallQueryList.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */

	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("wso2/call-query-group"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	public String getText(Object object) {
		return getString("_UI_CallQueryList_type");
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to
	 * update any cached
	 * children and by creating a viewer notification, which it passes to
	 * {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(CallQueryList.class)) {
			case DsPackage.CALL_QUERY_LIST__MIXED:
			case DsPackage.CALL_QUERY_LIST__CALL_QUERY:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(),
				                                         true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(DsPackage.Literals.CALL_QUERY_LIST__MIXED,
		                                             FeatureMapUtil.createEntry(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__COMMENT,
		                                                                        "")));

		newChildDescriptors.add(createChildParameter(DsPackage.Literals.CALL_QUERY_LIST__MIXED,
		                                             FeatureMapUtil.createEntry(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__TEXT,
		                                                                        "")));

		newChildDescriptors.add(createChildParameter(DsPackage.Literals.CALL_QUERY_LIST__MIXED,
		                                             FeatureMapUtil.createEntry(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__PROCESSING_INSTRUCTION,
		                                                                        XMLTypeFactory.eINSTANCE.createProcessingInstruction())));

		newChildDescriptors.add(createChildParameter(DsPackage.Literals.CALL_QUERY_LIST__MIXED,
		                                             FeatureMapUtil.createEntry(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__CDATA,
		                                                                        "")));

		newChildDescriptors.add(createChildParameter(DsPackage.Literals.CALL_QUERY_LIST__MIXED,
		                                             FeatureMapUtil.createEntry(DsPackage.Literals.CALL_QUERY_LIST__CALL_QUERY,
		                                                                        DsFactory.eINSTANCE.createCallQuery())));

		newChildDescriptors.add(createChildParameter(DsPackage.Literals.CALL_QUERY_LIST__CALL_QUERY,
		                                             DsFactory.eINSTANCE.createCallQuery()));
	}

	/**
	 * This returns the label text for
	 * {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child,
	                                 Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		if (childFeature instanceof EStructuralFeature &&
		    FeatureMapUtil.isFeatureMap((EStructuralFeature) childFeature)) {
			FeatureMap.Entry entry = (FeatureMap.Entry) childObject;
			childFeature = entry.getEStructuralFeature();
			childObject = entry.getValue();
		}

		boolean qualify = childFeature == DsPackage.Literals.CALL_QUERY_LIST__CALL_QUERY;

		if (qualify) {
			return getString("_UI_CreateChild_text2", new Object[] { getTypeText(childObject),
			                                                        getFeatureText(childFeature),
			                                                        getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	public ResourceLocator getResourceLocator() {
		return DsEditPlugin.INSTANCE;
	}

}
